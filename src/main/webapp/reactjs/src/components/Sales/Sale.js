import React, { Component } from "react";

import { connect } from "react-redux";
import {
  saveSale,
  fetchSale,
  updateSale,
  fetchLanguages,
  fetchGenres,
} from "../../services/index";

import { Card, Form, Button, Col, InputGroup, Image } from "react-bootstrap";
import { FontAwesomeIcon } from "@fortawesome/react-fontawesome";
import {
  faSave,
  faPlusSquare,
  faUndo,
  faList,
  faEdit,
} from "@fortawesome/free-solid-svg-icons";
import MyToast from "../MyToast";

class Sale extends Component {
  constructor(props) {
    super(props);
    this.state = this.initialState;
    this.state = {
      genres: [],
      languages: [],
      show: false,
    };
  }

  initialState = {
    id: "",
    title: "",
    author: "",
    coverPhotoURL: "",
    isbnNumber: "",
    price: "",
    language: "",
    genre: "",
  };

  componentDidMount() {
    const saleId = +this.props.match.params.id;
    if (saleId) {
      this.findSaleById(saleId);
    }
    //this.findAllLanguages();
  }

  // findAllLanguages = () => {
  //   this.props.fetchLanguages();
  //   setTimeout(() => {
  //     let bookLanguages = this.props.bookObject.languages;
  //     if (bookLanguages) {
  //       this.setState({
  //         languages: [{ value: "", display: "date_start" }].concat(
  //           bookLanguages.map((language) => {
  //             return { value: language, display: language };
  //           })
  //         ),
  //       });
  //       this.findAllGenres();
  //     }
  //   }, 100);
  // };

  findAllGenres = () => {
    this.props.fetchGenres();
    setTimeout(() => {
      let saleGenres = this.props.saleObject.genres;
      if (saleGenres) {
        this.setState({
          genres: [{ value: "", display: "Select date_end" }].concat(
              saleGenres.map((genre) => {
                return { value: genre, display: genre };
              })
          ),
        });
      }
    }, 100);
  };

  findSaleById = (saleId) => {
    this.props.fetchSale(saleId);
    setTimeout(() => {
      let sale = this.props.saleObject.sale;
      if (sale != null) {
        this.setState({
          id: sale.id,
          title: sale.title,
          author: sale.author,
          coverPhotoURL: sale.coverPhotoURL,
          isbnNumber: sale.isbnNumber,
          price: sale.price,
          language: sale.language,
          genre: sale.genre,
        });
      }
    }, 1000);
  };

  resetSale = () => {
    this.setState(() => this.initialState);
  };

  submitSale = (event) => {
    event.preventDefault();

    const sale = {
      title: this.state.title,
      author: this.state.author,
      coverPhotoURL: this.state.coverPhotoURL,
      isbnNumber: this.state.isbnNumber,
      price: this.state.price,
      language: this.state.language,
      genre: this.state.genre,
    };

    this.props.saveSale(sale);
    setTimeout(() => {
      if (this.props.saleObject.sale != null) {
        this.setState({ show: true, method: "post" });
        setTimeout(() => this.setState({ show: false }), 3000);
      } else {
        this.setState({ show: false });
      }
    }, 2000);
    this.setState(this.initialState);
  };

  updateSale = (event) => {
    event.preventDefault();

    const sale = {
      id: this.state.id,
      title: this.state.title,
      author: this.state.author,
      coverPhotoURL: this.state.coverPhotoURL,
      isbnNumber: this.state.isbnNumber,
      price: this.state.price,
      language: this.state.language,
      genre: this.state.genre,
    };
    this.props.updateSale(sale);
    setTimeout(() => {
      if (this.props.saleObject.sale != null) {
        this.setState({ show: true, method: "put" });
        setTimeout(() => this.setState({ show: false }), 3000);
      } else {
        this.setState({ show: false });
      }
    }, 2000);
    this.setState(this.initialState);
  };

  saleChange = (event) => {
    this.setState({
      [event.target.name]: event.target.value,
    });
  };

  saleList = () => {
    return this.props.history.push("/list");
  };

  render() {
    const { title, author, coverPhotoURL, isbnNumber, price, language, genre } =
        this.state;

    return (
        <div>
          <div style={{ display: this.state.show ? "block" : "none" }}>
            <MyToast
                show={this.state.show}
                message={
                  this.state.method === "put"
                      ? "Sale Updated Successfully."
                      : "Sale Saved Successfully."
                }
                type={"success"}
            />
          </div>
          <Card className={"border border-dark bg-dark text-white"}>
            <Card.Header>
              <FontAwesomeIcon icon={this.state.id ? faEdit : faPlusSquare} />{" "}
              {this.state.id ? "Update Sale" : "Add New Sale"}
            </Card.Header>
            <Form
                onReset={this.resetSale}
                onSubmit={this.state.id ? this.updateSale : this.submitSale}
                id="saleFormId"
            >
              <Card.Body>
                <Form.Row>
                  <Form.Group as={Col} controlId="formGridTitle">
                    <Form.Label>Title</Form.Label>
                    <Form.Control
                        required
                        autoComplete="off"
                        type="test"
                        name="title"
                        value={title}
                        onChange={this.saleChange}
                        className={"bg-dark text-white"}
                        placeholder="Enter Sale Title"
                    />
                  </Form.Group>
                  <Form.Group as={Col} controlId="formGridAuthor">
                    <Form.Label>magazine</Form.Label>
                    <Form.Control
                        required
                        autoComplete="off"
                        type="test"
                        name="author"
                        value={author}
                        onChange={this.saleChange}
                        className={"bg-dark text-white"}
                        placeholder="Enter Magazine"
                    />
                  </Form.Group>
                </Form.Row>
                <Form.Row>
                  <Form.Group as={Col} controlId="formGridCoverPhotoURL">
                    <Form.Label>Cover Photo URL</Form.Label>
                    <InputGroup>
                      <Form.Control
                          required
                          autoComplete="off"
                          type="test"
                          name="coverPhotoURL"
                          value={coverPhotoURL}
                          onChange={this.saleChange}
                          className={"bg-dark text-white"}
                          placeholder="Enter Sale Cover Photo URL"
                      />
                      <InputGroup.Append>
                        {this.state.coverPhotoURL !== "" && (
                            <Image
                                src={this.state.coverPhotoURL}
                                roundedRight
                                width="40"
                                height="38"
                            />
                        )}
                      </InputGroup.Append>
                    </InputGroup>
                  </Form.Group>
                  <Form.Group as={Col} controlId="formGridISBNNumber">
                    <Form.Label>OLD_PRICE</Form.Label>
                    <Form.Control
                        required
                        autoComplete="off"
                        type="test"
                        name="isbnNumber"
                        value={isbnNumber}
                        onChange={this.saleChange}
                        className={"bg-dark text-white"}
                        placeholder="Enter Sale OLD_PRICE"
                    />
                  </Form.Group>
                </Form.Row>
                <Form.Row>
                  <Form.Group as={Col} controlId="formGridPrice">
                    <Form.Label>NEW_PRICE</Form.Label>
                    <Form.Control
                        required
                        autoComplete="off"
                        type="test"
                        name="price"
                        value={price}
                        onChange={this.saleChange}
                        className={"bg-dark text-white"}
                        placeholder="Enter Sale NEW_PRICE"
                    />
                  </Form.Group>
                  <Form.Group as={Col} controlId="formGridLanguage">
                    <Form.Label>date_start</Form.Label>
                    <Form.Control
                        required
                        autoComplete="off"
                        type="test"
                        onChange={this.saleChange}
                        name="language"
                        value={language}
                        className={"bg-dark text-white"}
                        placeholder="date_start"
                    />
                  </Form.Group>
                  <Form.Group as={Col} controlId="formGridGenre">
                    <Form.Label>date_end</Form.Label>
                    <Form.Control
                        required
                        autoComplete="off"
                        type="test"
                        onChange={this.saleChange}
                        name="genre"
                        value={genre}
                        className={"bg-dark text-white"}
                        placeholder="date_end"
                    />
                  </Form.Group>
                </Form.Row>
              </Card.Body>
              <Card.Footer style={{ textAlign: "right" }}>
                <Button size="sm" variant="success" type="submit">
                  <FontAwesomeIcon icon={faSave} />{" "}
                  {this.state.id ? "Update" : "Save"}
                </Button>{" "}
                <Button size="sm" variant="info" type="reset">
                  <FontAwesomeIcon icon={faUndo} /> Reset
                </Button>{" "}
                <Button
                    size="sm"
                    variant="info"
                    type="button"
                    onClick={() => this.saleList()}
                >
                  <FontAwesomeIcon icon={faList} /> Sale List
                </Button>
              </Card.Footer>
            </Form>
          </Card>
        </div>
    );
  }
}

const mapStateToProps = (state) => {
  return {
    saleObject: state.sale,
  };
};

const mapDispatchToProps = (dispatch) => {
  return {
    saveSale: (sale) => dispatch(saveSale(sale)),
    fetchSale: (saleId) => dispatch(fetchSale(saleId)),
    updateSale: (sale) => dispatch(updateSale(sale)),
    fetchLanguages: () => dispatch(fetchLanguages()),
    fetchGenres: () => dispatch(fetchGenres()),
  };
};

export default connect(mapStateToProps, mapDispatchToProps)(Sale);
