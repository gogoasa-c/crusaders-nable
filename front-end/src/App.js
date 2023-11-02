import "./App.css";
import logo from "./logo_noBG.png";
import { useState, useEffect } from 'react'
import SearchIcon from "./components/search.svg";
import Event from "./components/event.jsx";
import axios from "axios";

let tempNames = [];
let tempImageUrls = [];
let tempLocations = [];
let tempStartTimes = [];
let tempDescriptions = [];
let tempActivityTags = [];

const GenerateList = () => {
  const [names, setNames] = useState([]);
  const [imageUrls, setImageUrls] = useState([]);
  const [locations, setLocations] = useState([]);
  const [startTimes, setStartTimes] = useState([]);
  const [descriptions, setDescriptions] = useState([]);
  const [activityTags, setActivityTags] = useState([]);
  useEffect(()=>{
    const callDb = async () => {

      let url = "http://localhost:8080/activity/all";
    
      const response = await axios.get(url);
      const responseData = response.data;
        responseData.forEach((element) => {
          tempNames.push(element["name"]);
          tempImageUrls.push(element["imageUrl"]);
          tempLocations.push(element["location"]);
          tempStartTimes.push(element["startTime"]);
          tempDescriptions.push(element["description"]);
          tempActivityTags.push(element["activityTagList"]);
        });

        setNames(tempNames);
        setImageUrls(tempImageUrls);
        setLocations(tempLocations);
        setStartTimes(tempStartTimes);
        setDescriptions(tempDescriptions);
        setActivityTags(tempActivityTags);
    };
    callDb();
  }, [])
  let content = [];
  for (let index = 0; index < names.length; index+=2) {
    content.push(
      <div className="doubleEventContainer">
        <div className="singleEventContainer">
          <Event
            name={names[index]}
            location={locations[index]}
            startTime={startTimes[index]}
            image={imageUrls[index]}
          ></Event>
        </div>
        <div className="singleEventContainer">
          <Event
            name={names[index + 1]}
            location={locations[index + 1]}
            startTime={startTimes[index + 1]}
            image={imageUrls[index + 1]}
          ></Event>
        </div>
      </div>
    );
    if (index == names.length + 1) {
      <div className="doubleEventContainer" id={index}>
        <div className="singleEventContainer">
          <Event
            name={names[index]}
            location={locations[index]}
            startTime={startTimes[index]}
            image={imageUrls[index]}
          ></Event>
        </div>
      </div>;
    }
  }
  return (content.map((events, i) =>
  <li key={i}>{events}</li>));
};

function App() {
  console.log("Apelare App()");
  let eventsList = GenerateList()
  return (
    <>
      <div className="App">
        <div className="barContainer">
          <img src={logo} className="logo"></img>
          <h1 className="name">AIDATLAS</h1>
          <div className="search_box">
            <input type="text" placeholder="Search"></input>
            <img
              className="search_icon"
              src={SearchIcon}
            ></img>
          </div>
          <div className="userContainer">
            <a
              href="#"
              className="btn_login"
              onClick={() => {
                document.getElementById("popup-login").style.visibility =
                  "visible";
              }}
            >
              <span>Login</span>
            </a>
            <a
              href="https://paypal.me/aidatlas?country.x=RO&locale.x=en_US"
              className="btn_donate"
            >
              <span>Donate</span>
            </a>
          </div>
          {/* <button type="button" onclick="openPopup()"><span>Login</span></button> */}
          <div className="popup" id="popup-login">
            <div
              className="btn-close"
              onClick={() => {
                document.getElementById("popup-login").style.visibility =
                  "hidden";
              }}
            >
              &times;
            </div>
            <div className="form">
              <h2>Log in</h2>
              <div className="form-element">
                <label htmlFor="email">Email</label>
                <input type="text" id="email" placeholder="Enter email"></input>
              </div>
              <div className="form-element">
                <label htmlFor="password">Password</label>
                <input
                  type="password"
                  id="password"
                  placeholder="Enter password"
                ></input>
              </div>
              <div className="form-element">
                <button
                  type="button"
                  onClick={() => {
                    document.getElementById("popup-login").style.visibility =
                      "hidden";
                  }}
                >
                  Sign in
                </button>
              </div>
              <div className="form-element">
                <a href="#">Forgot password?</a>
              </div>
            </div>
          </div>

          <div className="popup" id="popup-donate">
            <div
              className="btn-close"
              onClick={() => {
                document.getElementById("popup-donate").style.visibility =
                  "hidden";
              }}
            >
              &times;
            </div>
            <div className="form">
              <h2>Donate</h2>
              <div className="form-element"></div>
              <div className="form-element"></div>
              <div className="form-element">
                <button
                  type="button"
                  onClick={() => {
                    document.getElementById("popup-donate").style.visibility =
                      "hidden";
                  }}
                >
                  Donate
                </button>
              </div>
            </div>
          </div>
        </div>  
        <div className="eventsContainer">
          <ul>
            {eventsList}
          </ul>
        </div>
      </div>
    </>
  );
}

export default App;
