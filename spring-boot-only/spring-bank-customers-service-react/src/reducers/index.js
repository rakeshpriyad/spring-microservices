import { combineReducers } from "redux";
import errorReducer from "./errorReducer";
import customerReducer from "./customerReducer";
import userReducer from "./userReducer";

export default combineReducers({
  errors: errorReducer,
  customer: customerReducer,
  user: userReducer
});
