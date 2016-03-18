import React, { Component, PropTypes } from "react"
import Hello from "../components/HelloWorld"
import Header from "../components/header/header"
import { getHospitals } from "../api"
export default class App extends Component {
  constructor() {
    super();

    this.state = {
      list : []
    }

    getHospitals(data => {
      this.setState({
        list : data
      })
    })
  }

  render(){
    return (
      <div>
        <Hello />
        <Header />
      </div>
    )
  }
}
