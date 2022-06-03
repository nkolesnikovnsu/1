import { combineReducers } from "redux";
import userReducer from "./user/userReducer";
import authReducer from "./user/auth/authReducer";
import saleReducer from "./sale/saleReducer";

const rootReducer = combineReducers({
  user: userReducer,
  sale: saleReducer,
  auth: authReducer,
});

export default rootReducer;
