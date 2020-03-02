import axios from "axios";
import { GET_ERRORS, GET_USERS } from "./types";

export const createUser = (user, history) => async dispatch => {
  try {
    const res = await axios.post("http://localhost:8090/user/", user);
    console.log(res);
    history.push("/dashboard");
  } catch (err) {
    console.log(err)
    dispatch({
      type: GET_ERRORS,
      payload: err.response.data
    });
  }
};

export const getUsers = () => async dispatch => {
  const res = await axios.get("http://localhost:8090/user/all");
  console.log(res);
  dispatch({
    type: GET_USERS,
    payload: res.data
  });
};
