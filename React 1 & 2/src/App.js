
import './App.css';
import React, { Component } from "react";
import TodoCards from './Input';


class App extends Component {

  constructor() {
     super();
     
    this.state = {
      todoCards:[
        {
          title:'Task1',
          description:'Home task',
          completion_date: "2021-01-23",
          
        },
        {
          title:'Task2',
          description:'Work task',
          completion_date: "2021-01-22",
          
        },
        {
          title:'Task3',
          description:'College task',
          completion_date: "2021-01-29",
          
        },
      ],
    };
  }
  
  
   sorttodo = () => {
    const todo= this.state.todoCards;
    
    const sorted=todo.sort((a,b)=>
      new Date(a.completion_date)- new Date(b.completion_date)
      );
    this.setState({sorted});
   }
   renderCards = () => {
    return this.state.todoCards.map((obj, index) => {
      return <TodoCards data={obj} key={index} deleteCard={this.deleteCard} index={index} />
    })
   }
   deleteCard = (index) => {
    console.log('index',index);
    if (index > -1) {
      var arr=this.state.todoCards.splice(index,1);
      this.setState({arr});
    }
   }
   addCard = () => {
     console.log("add called");
    var t=document.getElementById("title").value;
    var d=document.getElementById("desc").value;
    var da=document.getElementById("date").value;
    var addarr=this.state.todoCards.push({title:t,description:d,completion_date:da});
    this.setState({addarr});
   }

  render(){
    return (
      <React.Fragment>
      <h1 align='center'>Todo List:</h1>
      
      <div align="center">
      <button onClick={()=>this.sorttodo()}>Sort</button>
      <br></br>
      <input style={{ width: '50%' }} id="title" type="text" placeholder="Enter new todo Title" />
      <input style={{ width: '50%' }} id="desc" type="text" placeholder="Enter new todo Description" />
      <input style={{ width: '50%' }} id="date" type="text" placeholder="Enter new todo Completion Date (DD/MM/YYYY)" />
      <br></br>
      <button onClick={()=>this.addCard()}>Add note</button>
      </div>
      
      {this.renderCards()}

      </React.Fragment>
      
    )
  }
 
}
  


export default App