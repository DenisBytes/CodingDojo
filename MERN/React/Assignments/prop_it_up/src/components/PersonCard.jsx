import React, { Component } from "react";

export class PersonCard extends Component{

    constructor(props){
        super(props);  
        this.state = {
            age: 0
        };
    }

    flipSwitch = ()=>this.setState({age: this.state.age+1});    
    render (){
        const {firstName, lastName, hairColor} = this.props;

        return (
            <div>
                <h1>{lastName}, {firstName}</h1>
                <p>Age: {this.state.age}</p>
                <p>Hair Color: {hairColor}</p>
                <button onClick={this.flipSwitch}>Increment Age</button>
            </div>
        );
    }

}

