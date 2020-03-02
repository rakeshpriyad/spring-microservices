import React, { Component } from "react";
import UserItem from "./User/UserItem";
import CreateUserButton from "./User/CreateUserButton";
import { connect } from "react-redux";
import { getUsers } from "../actions/userActions";
import PropTypes from "prop-types";

class Signup extends Component {
  componentDidMount() {
    this.props.getUsers();
  }

  render() {
    const { users } = this.props.user;

    return (
      <div className="users">
        <div className="container">
          <div className="row">
            <div className="col-md-12">
              <h1 className="display-4 text-center">Users</h1>
              <br />
              <CreateUserButton />

              <br />
              <hr />
              {users.map(user => (
                <UserItem key={user.firstName} project={user} />
              ))}
            </div>
          </div>
        </div>
      </div>
    );
  }
}

Signup.propTypes = {
  user: PropTypes.object.isRequired,
  getUsers: PropTypes.func.isRequired
};

const mapStateToProps = state => ({
  user: state.user
});

export default connect(
  mapStateToProps,
  { getUsers }
)(Signup);
