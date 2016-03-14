import React from "react"

class Hello extends React.Component {

  render(){
    const { list ,   onclick} = this.props;
    return (
      <ul>
        <h1 style={{fontSize:"80px"}}>Hello</h1>
        {
          list && list.length && list.map( item =>{
            return (
              <li onClick={e => onclick()}>{item.name}</li>
            )
          })
        }
      </ul>
    );
  }

}

export default Hello;
