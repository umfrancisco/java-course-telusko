import React, { useState } from 'react';
import './App.css';

function App() {
  const [inputText, setInputText] = useState('');
  const [response, setResponse] = useState('');
  const [isLoading, setIsLoading] = useState(false);
  const [error, setError] = useState(null);

  const handleSubmit = async (e) => {
    e.preventDefault();
    if (!inputText.trim()) return;

    setIsLoading(true);
    setError(null);
    setResponse('');

    try {
      // Note: Ensure your server has CORS enabled to accept requests from this React app
      const res = await fetch(`http://localhost:8080/ai/${encodeURIComponent(inputText)}`);
      
      if (!res.ok) {
        throw new Error(`Server error: ${res.status}`);
      }

      // Parsing as .text() because the endpoint returns a plain string
      const data = await res.text();
      setResponse(data);
    } catch (err) {
      setError(err.message || 'Failed to connect to the AI endpoint.');
    } finally {
      setIsLoading(false);
    }
  };

  return (
    <div className="app-container">
      <div className="glass-card">
        <h1 className="title">AI Text Generator</h1>
        <p className="subtitle">Enter your prompt</p>
        
        <form onSubmit={handleSubmit} className="input-form">
          <input
            type="text"
            className="text-input"
            placeholder="Type something..."
            value={inputText}
            onChange={(e) => setInputText(e.target.value)}
            disabled={isLoading}
          />
          <button type="submit" className="submit-btn" disabled={isLoading || !inputText}>
            {isLoading ? <span className="spinner"></span> : 'Generate'}
          </button>
        </form>

        {error && <div className="error-box">{error}</div>}
        
        {response && (
          <div className="response-box">
            <h3>Response:</h3>
            <p>{response}</p>
          </div>
        )}
      </div>
    </div>
  );
}

export default App;