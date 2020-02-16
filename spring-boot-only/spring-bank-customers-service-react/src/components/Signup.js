import React, { Component } from "react";
import ProjectItem from "./Customer/CustomerItem";
import CreateProjectButton from "./Customer/CreateCustomerButton";
import { connect } from "react-redux";
import { getProjects } from "../actions/customerActions";
import PropTypes from "prop-types";

class Signup extends Component {
  componentDidMount() {
    this.props.getCustomers();
  }

  render() {
    const { users } = this.props.users;

    return (
      <div className="projects">
        <div className="container">
          <div className="row">
            <div className="col-md-12">
              <h1 className="display-4 text-center">Users</h1>
              <br />
              <CreateCustomerButton />

              <br />
              <hr />
              {customers.map(user => (
                <CustomerItem key={customer.firstName} project={customer} />
              ))}
            </div>
          </div>
        </div>
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
