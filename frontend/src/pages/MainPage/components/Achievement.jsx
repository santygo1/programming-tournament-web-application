import React from 'react';


const Achievement = ({title, text}) => {
    return (
        <div style={{display:"flex", flexDirection: "column", gap: "20px"}}>
            <h2 style={{fontSize: "4em"}}>{title}</h2>
            <h4>{text}</h4>
        </div>
    );
};

export default Achievement;