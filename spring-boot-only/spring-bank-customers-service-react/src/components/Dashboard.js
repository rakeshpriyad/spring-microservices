import React, { Component } from "react";
import CustomerItem from "./Customer/CustomerItem";
import CreateCustomerButton from "./Customer/CreateCustomerButton";
import { connect } from "react-redux";
import { getCustomers } from "../actions/customerActions";
import PropTypes from "prop-types";
import ShippingForm from "../components/shiping/shippingForm"

class Dashboard extends Component {
  componentDidMount() {
    this.props.getCustomers();
  }

  render() {
    const { customers } = this.props.customer;

    return (
      <div className="customers">
        <div className="container">
          <div className="row">
            <div className="col-md-12">
              
              <CreateCustomerButton />

              <br />
              <hr />
              <div className="container">
        <div className="card card-body bg-light mb-3">
        
          <div className="row">
            <div className="col-2">
              <span className="mx-auto"><h3>First Name</h3></span>
            </div>
            <div className="col-2">
              <span className="mx-auto"><h3>Last Name</h3></span>
            </div>
            <div className="col-2">
              <span className="mx-auto"><h3>Address</h3></span>
            </div>
            <div className="col-2">
              <span className="mx-auto"><h3>City</h3></span>
            </div>
            <div className="col-2">
              <span className="mx-auto"><h3>Contact No#</h3></span>
            </div>
          </div>
        </div>
      </div>
              {customers.map(customer => (
                <CustomerItem key={customer.firstName} customer={customer} />
              ))}
            </div>
          </div>
        </div>
        <ShippingForm />
      </div>
    );
  }
}

Dashboard.propTypes = {
  customer: PropTypes.object.isRequired,
  getCustomers: PropTypes.func.isRequired
};

const mapStateToProps = state => ({
  customer: state.customer
});

export default connect(
  mapStateToProps,
  { getCustomers }
)(Dashboard);
