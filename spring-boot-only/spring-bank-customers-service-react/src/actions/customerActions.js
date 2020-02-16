import axios from "axios";
import { GET_ERRORS, GET_CUSTOMERS } from "./types";

export const createCustomer = (customer, history) => async dispatch => {
  try {
    const res = await axios.post("http://localhost:8090/customer/", customer);
    history.push("/dashboard");
  } catch (err) {
    console.log(err)
    dispatch({
      type: GET_ERRORS,
      payload: err.response.data
    });
  }
};

export const getCustomers = () => async dispatch => {
  const res = await axios.get("http://localhost:8090/customer/all");
  dispatch({
    type: GET_CUSTOMERS,
    payload: res.data
  });
};
