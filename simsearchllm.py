import streamlit as st
from langchain.chains import ConversationalRetrievalChain
from langchain.llms import CTransformers
from langchain.memory import ConversationBufferMemory
from langchain_community.embeddings import HuggingFaceEmbeddings
from langchain_community.vectorstores.neo4j_vector import Neo4jVector
from neo4j import GraphDatabase

# Set up the Streamlit app title
st.title('Chat')

# Define the Neo4j database connection
driver = GraphDatabase.driver(uri="bolt+s://185c5229.databases.neo4j.io:7687",
                            auth=("neo4j", "UNBbW3b5O5oO8m7ncgI7C8rHs3EigkEpg39CHEtaQ4E"))

# Define the embedding provider
embedding_provider = HuggingFaceEmbeddings(model_name="bert-base-nli-mean-tokens")

# Define the Language Model
llm = CTransformers(model="C:/Users/nivedha.b/PycharmProjects/pythonProject1/.venv/model/mistral-7b-instruct-v0.2.Q4_K_M.gguf",
                     config={'max_new_tokens': 512, 'temperature': 0.3, 'context_length': 5000})

# Define the Neo4jVector retriever
DocSummary_vector = Neo4jVector.from_existing_index(
    embedding_provider,
    url="bolt+s://185c5229.databases.neo4j.io:7687",
    username="neo4j",
    password="UNBbW3b5O5oO8m7ncgI7C8rHs3EigkEpg39CHEtaQ4E",
    index_name="DocSummary",
    embedding_node_property="embedding",
    text_node_property="text"
)
def name(query):
    hits = DocSummary_vector.similarity_search_with_score(query,k=1)
    for i in hits:
        doc = i[0].metadata["name"]
        return str(doc.split("_")[0])

# Initialize conversation history
if 'history' not in st.session_state:
    st.session_state['history'] = []

if 'generated' not in st.session_state:
    st.session_state['generated'] = []

if 'past' not in st.session_state:
    st.session_state['past'] = []

# Define the memory
memory = ConversationBufferMemory(memory_key="chat_history", return_messages=True)

# Define the Conversational Retrieval Chain
chain = ConversationalRetrievalChain.from_llm(llm=llm, chain_type='stuff',
                                              retriever=DocSummary_vector.as_retriever(search_kwargs={"k": 2}),
                                              memory=memory)


# Display chat history
reply_container = st.container()
container = st.container()

with container:
    with st.form(key='my_form', clear_on_submit=True):
        user_input = st.text_input("Ask Me", placeholder="Type your question here", key='input')
        submit_button = st.form_submit_button(label='Send')

    if submit_button and user_input:

        docname = name(user_input)
        print(docname)
        result = chain({"question": user_input, "chat_history": st.session_state['history']})
        st.session_state['history'].append((user_input, result["answer"]))
        st.session_state['past'].append(user_input)
        st.session_state['generated'].append(result["answer"])
        with driver.session() as session:
            query = """
               MATCH (d:Document {name: $document_name})
               SET d.referenced = d.referenced + 1
               """
            result = session.run(query, document_name=docname)
            print("success")

if st.session_state['generated']:
    with reply_container:
        for i in range(len(st.session_state['generated'])):
            st.write(st.session_state['past'][i])
            st.info(st.session_state['generated'][i])

# Close the Neo4j driver
driver.close()
