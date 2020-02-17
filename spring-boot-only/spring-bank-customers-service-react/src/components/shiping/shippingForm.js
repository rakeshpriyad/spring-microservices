import React, { Component } from "react";
import PropTypes from "prop-types";
import { connect } from "react-redux";
import { createUser } from "../../actions/userActions";
import { Button, Divider, Form } from 'semantic-ui-react'
import classnames from "classnames";

class ShippingForm extends Component {
    render() {
        return (
            <div>
         <Form >
        <Form.Group widths='equal'>
          <Form.Field
            label='First name'
            control='input'
            placeholder='First name'
          />
          <Form.Field
            label='Last name'
            control='input'
            placeholder='Last name'
          />
        </Form.Group>
        <Button type='submit'>Submit</Button>
        <Divider hidden />
      </Form>
  </div>
  
);
}
}
export default ShippingForm;
