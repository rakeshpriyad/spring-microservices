import React, { Component } from "react";

class CustomerItem extends Component {
  render() {
    const { customer } = this.props;
    return (
      <div className="container">
        <div className="card card-body bg-light mb-3">
        
          <div className="row">
        
            <div className="col-2">
              <span className="mx-auto">{customer.firstName}</span>
            </div>
            <div className="col-2">
              <span className="mx-auto">{customer.lastName}</span>
            </div>
            <div className="col-2">
              <span className="mx-auto">{customer.address}</span>
            </div>
            <div className="col-2">
              <span className="mx-auto">{customer.city}</span>
            </div>
            <div className="col-2">
              <span className="mx-auto">{customer.telephone}</span>
            </div>
          </div>
        </div>
      </div>
    );
  }
}

export default CustomerItem;
