import './App.css';
//import { useState } from 'react'

const generateList = ()=>{
  let content=[]
  for(let i = 0; i < 4; i++)
  content.push('Element '+i)
  return content
}

function App() {
  return (
    <>
      <div className="App">
        <>
          <div className="List">
            <ul>{generateList().map(row=><li>{row}</li>)}</ul>
          </div>
        </>
      </div>
    </>
  );
}

export default App;
