import './App.css';
import logo from "./logo_noBG.png";
//import { useState } from 'react'
import SearchIcon from './components/search.svg'
import Event from './components/event.jsx'

let names=["Ingrijire animale", "Curatare parc", "Pisici", "Serving food at homeless shelter", "N/A"]
let imageUrls=["https://upload.wikimedia.org/wikipedia/commons/thumb/4/48/RedCat_8727.jpg/1200px-RedCat_8727.jp",
"https://dynamic-media-cdn.tripadvisor.com/media/photo-o/0f/8a/1d/f5/herastrau-park.jpg?w=1200&h=-1&s=1",
"https://upload.wikimedia.org/wikipedia/commons/thumb/4/48/RedCat_8727.jpg/1200px-RedCat_8727.jpg",
"https://d2gg9evh47fn9z.cloudfront.net/800px_COLOURBOX10274842.jpg", "nono"]
let locations=["Location1", "Location2", "Location3", "Location4", "Location5"]
let startTimes=["Time1", "Time2", "Time3", "Time4", "Time5"]
//new Date(startTime)

const callDb = () => {
  let url = "http://localhost:8080/activity/all";

  axios.get(url).then(
    (response) => {
      let responseData = response.data;
      responseData.forEach(element => {
        names.push(element['name']);
        imageUrls.push(element['imageUrl']);
        locations.push(element['location']);
        startTimes.push(element['startTime']);
        descriptions.push(element['description']);
        activityTags.push(element['activityTagList']);
      });
      
    }
  )
}

callDb();

const generateList = ()=>{
  let content=[]
  for(let i = 0; i < names.length; i+=2){
    content.push(
      <div className="doubleEventContainer">
        <div className="singleEventContainer">
          <Event name={names[i]} location={locations[i]}  startTime={startTimes[i]} 
            image={imageUrls[i]}>
          </Event>
        </div>
        <div className="singleEventContainer">
        <Event name={names[i+1]} location={locations[i+1]}  startTime={startTimes[i+1]}
          image={imageUrls[i+1]}>
        </Event>
        </div>
      </div>
      )
    if(i == names.length+1)
    {
      <div className="doubleEventContainer">
        <div className="singleEventContainer">
          <Event name={names[i]} location={locations[i]}  startTime={startTimes[i]} 
            image={imageUrls[i]}>
          </Event>
        </div>
      </div>
    }
  }
  return content
}

function App() {
  return (
    <>
      <div className="App">
        <div className="barContainer">
          <img src={logo} className="logo"></img>
          <h1 className="name">AIDATLAS</h1>
          <div className="search_box">
            <input type="text" placeholder="Search"></input>
            <img className="search_icon"src={SearchIcon} onClick={()=>{console.log("BOO")}}></img>
          </div>
          <div className="userContainer">
            <a href="#" className="btn_login" onClick={()=>{document.getElementById('popup-login').style.visibility="visible"}}><span>Login</span></a>
            <a href="https://paypal.me/aidatlas?country.x=RO&locale.x=en_US" className="btn_donate"><span>Donate</span></a>
          </div>
            {/* <button type="button" onclick="openPopup()"><span>Login</span></button> */}
            <div className="popup" id="popup-login">
              <div className="btn-close" onClick={()=>{document.getElementById('popup-login').style.visibility="hidden"}}>&times;</div>
              <div className="form">
                <h2>Log in</h2>
                <div className="form-element">
                  <label for="email">Email</label>
                  <input type="text" id="email" placeholder="Enter email"></input>
                </div>
                <div className="form-element">
                  <label for="password">Password</label>
                  <input type="password" id="password" placeholder="Enter password"></input>
                </div>
                <div className="form-element">
                  <button type="button" onClick={()=>{document.getElementById('popup-login').style.visibility="hidden"}}>Sign in</button>
                </div>
                <div className="form-element">
                    <a href="#">Forgot password?</a>
                </div>
              </div>
            </div>


            <div className="popup" id="popup-donate">
              <div className="btn-close" onClick={()=>{document.getElementById('popup-donate').style.visibility="hidden"}}>&times;</div>
              <div className="form">
                <h2>Donate</h2>
                <div className="form-element">
                  
                </div>
                <div className="form-element">
                  
                </div>
                <div className="form-element">
                  <button type="button" onClick={()=>{document.getElementById('popup-donate').style.visibility="hidden"}}>Donate</button>
                </div>
              </div>
            </div>
        </div>
        <div className="eventsContainer">
          <ul>{generateList().map(event=><li>{event}</li>)}</ul>
        </div>
      </div>
    </>
  );
}

export default App;
