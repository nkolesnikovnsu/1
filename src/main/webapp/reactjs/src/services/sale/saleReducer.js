import * as BT from "./saleTypes";

const initialState = {
  sale: "",
  error: "",
};

const reducer = (state = initialState, action) => {
  switch (action.type) {
    case BT.SAVE_SALE_REQUEST:
    case BT.FETCH_SALE_REQUEST:
    case BT.UPDATE_SALE_REQUEST:
    case BT.DELETE_SALE_REQUEST:
    case BT.FETCH_LANGUAGES_REQUEST:
    case BT.FETCH_GENRES_REQUEST:
      return {
        ...state,
      };
    case BT.SALE_SUCCESS:
      return {
        sale: action.payload,
        error: "",
      };
    case BT.SALE_FAILURE:
      return {
        sale: "",
        error: action.payload,
      };
    case BT.LANGUAGES_SUCCESS:
      return {
        languages: action.payload,
        error: "",
      };
    case BT.LANGUAGES_FAILURE:
      return {
        languages: "",
        error: action.payload,
      };
    case BT.GENRES_SUCCESS:
      return {
        genres: action.payload,
        error: "",
      };
    case BT.GENRES_FAILURE:
      return {
        genres: "",
        error: action.payload,
      };
    default:
      return state;
  }
};

export default reducer;
