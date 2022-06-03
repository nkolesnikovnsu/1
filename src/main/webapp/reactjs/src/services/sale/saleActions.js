import * as BT from "./saleTypes";
import axios from "axios";

export const saveSale = (sale) => {
  return (dispatch) => {
    dispatch({
      type: BT.SAVE_SALE_REQUEST,
    });
    axios
      .post("http://localhost:8080/rest/sales", sale)
      .then((response) => {
        dispatch(saleSuccess(response.data));
      })
      .catch((error) => {
        dispatch(saleFailure(error));
      });
  };
};

export const fetchSale = (saleId) => {
  return (dispatch) => {
    dispatch({
      type: BT.FETCH_SALE_REQUEST,
    });
    axios
      .get("http://localhost:8080/rest/sales/" + saleId)
      .then((response) => {
        dispatch(saleSuccess(response.data));
      })
      .catch((error) => {
        dispatch(saleFailure(error));
      });
  };
};

export const updateSale = (sale) => {
  return (dispatch) => {
    dispatch({
      type: BT.UPDATE_SALE_REQUEST,
    });
    axios
      .put("http://localhost:8080/rest/sales", sale)
      .then((response) => {
        dispatch(saleSuccess(response.data));
      })
      .catch((error) => {
        dispatch(saleFailure(error));
      });
  };
};

export const deleteSale = (saleId) => {
  return (dispatch) => {
    dispatch({
      type: BT.DELETE_SALE_REQUEST,
    });
    axios
      .delete("http://localhost:8080/rest/sales/" + saleId)
      .then((response) => {
        dispatch(saleSuccess(response.data));
      })
      .catch((error) => {
        dispatch(saleFailure(error));
      });
  };
};

const saleSuccess = (sale) => {
  return {
    type: BT.SALE_SUCCESS,
    payload: sale,
  };
};

const saleFailure = (error) => {
  return {
    type: BT.SALE_FAILURE,
    payload: error,
  };
};

export const fetchLanguages = () => {
  return (dispatch) => {
    dispatch({
      type: BT.FETCH_LANGUAGES_REQUEST,
    });
    axios
      .get("http://localhost:8080/rest/sales/languages")
      .then((response) => {
        dispatch({
          type: BT.LANGUAGES_SUCCESS,
          payload: response.data,
        });
      })
      .catch((error) => {
        dispatch({
          type: BT.LANGUAGES_FAILURE,
          payload: error,
        });
      });
  };
};

export const fetchGenres = () => {
  return (dispatch) => {
    dispatch({
      type: BT.FETCH_GENRES_REQUEST,
    });
    axios
      .get("http://localhost:8080/rest/sales/genres")
      .then((response) => {
        dispatch({
          type: BT.GENRES_SUCCESS,
          payload: response.data,
        });
      })
      .catch((error) => {
        dispatch({
          type: BT.GENRES_FAILURE,
          payload: error,
        });
      });
  };
};
