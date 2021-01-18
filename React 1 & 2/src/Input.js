import React from "react";

function TodoCards(props) {

    return (
        
        <div align='center' className={{border: '1px solid #000'}}>
            <br></br>
            <div>
            <span>{props?.data?.title || 'Task'}</span>
            </div>
            <div>
            <span>{props?.data?.description || 'Empty'}</span>
            </div>
            <div><span>{props?.data?.completion_date || '14/01/2021'}</span>
            </div>
            
            <button onClick={()=>props.deleteCard(props.index)}>Delete Todo</button>
            <br></br>
            
        </div>        
    )
}
export default TodoCards
