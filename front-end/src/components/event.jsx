import { useState } from "react";

function Event(props) {
  const [imageExists, setImageExists] = useState(true);

  const handleImageError = () => {
    setImageExists(false);
  };

  const handleImageLoad = () => {
    setImageExists(true);
  };
  if (props.name)
    return (
      <>
        <h2>{props.name}</h2>
        <h3>{props.location}</h3>
        <p align="right">{props.startTime}</p>
        <div>
          {imageExists ? (
            <img
              src={props.image}
              width="600"
              height="300"
              onError={handleImageError}
              onLoad={handleImageLoad}
            />
          ) : (
            <img src="https://via.placeholder.com/600x300" />
          )}
        </div>
      </>
    );
  else {
    return <div color="#e6f2fa"></div>;
  }
}

export default Event;
