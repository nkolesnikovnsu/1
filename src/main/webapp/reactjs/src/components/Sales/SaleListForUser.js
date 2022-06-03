import React, { Component } from "react";

import {connect, useSelector} from "react-redux";
import { deleteSale } from "../../services/index";

import "./../../assets/css/Style.css";
import {
    Card,
    Table,
    Image,
    ButtonGroup,
    Button,
    InputGroup,
    FormControl,
} from "react-bootstrap";
import { FontAwesomeIcon } from "@fortawesome/react-fontawesome";
import {
    faList,
    faEdit,
    faTrash,
    faStepBackward,
    faFastBackward,
    faStepForward,
    faFastForward,
    faSearch,
    faTimes,
} from "@fortawesome/free-solid-svg-icons";
import { Link } from "react-router-dom";
import MyToast from "../MyToast";
import axios from "axios";

class SaleList extends Component {
    constructor(props) {
        super(props);
        this.state = {
            sales: [],
            search: "",
            search_magazine: "",
            search_date_start: "",
            search_date_end: "",
            currentPage: 1,
            salesPerPage: 5,
            sortDir: "asc",
        };
    }

    sortData = () => {
        setTimeout(() => {
            this.state.sortDir === "asc"
                ? this.setState({ sortDir: "desc" })
                : this.setState({ sortDir: "asc" });
            this.findAllSales(this.state.currentPage);
        }, 500);
    };

    componentDidMount() {
        this.findAllSales(this.state.currentPage);
    }

    findAllSales(currentPage) {
        currentPage -= 1;
        axios
            .get(
                "http://localhost:8080/rest/sales?pageNumber=" +
                currentPage +
                "&pageSize=" +
                this.state.salesPerPage +
                "&sortBy=price&sortDir=" +
                this.state.sortDir
            )
            .then((response) => response.data)
            .then((data) => {
                this.setState({
                    sales: data.content,
                    totalPages: data.totalPages,
                    totalElements: data.totalElements,
                    currentPage: data.number + 1,
                });
            })
            .catch((error) => {
                console.log(error);
                localStorage.removeItem("jwtToken");
                this.props.history.push("/");
            });
    }

    deleteSale = (saleId) => {
        this.props.deleteSale(saleId);
        setTimeout(() => {
            if (this.props.saleObject != null) {
                this.setState({ show: true });
                setTimeout(() => this.setState({ show: false }), 3000);
                this.findAllSales(this.state.currentPage);
            } else {
                this.setState({ show: false });
            }
        }, 1000);
    };

    changePage = (event) => {
        let targetPage = parseInt(event.target.value);
        if (this.state.search) {
            this.searchData(targetPage);
        } else {
            this.findAllSales(targetPage);
        }
        this.setState({
            [event.target.name]: targetPage,
        });
    };

    firstPage = () => {
        let firstPage = 1;
        if (this.state.currentPage > firstPage) {
            if (this.state.search) {
                this.searchData(firstPage);
            } else {
                this.findAllSales(firstPage);
            }
        }
    };

    prevPage = () => {
        let prevPage = 1;
        if (this.state.currentPage > prevPage) {
            if (this.state.search) {
                this.searchData(this.state.currentPage - prevPage);
            } else {
                this.findAllSales(this.state.currentPage - prevPage);
            }
        }
    };

    lastPage = () => {
        let condition = Math.ceil(
            this.state.totalElements / this.state.salesPerPage
        );
        if (this.state.currentPage < condition) {
            if (this.state.search) {
                this.searchData(condition);
            } else if(this.state.search_magazine){
                this.searchData(condition);
            }else if(this.state.search_date_start){
                this.searchData(condition);
            }else if(this.state.search_date_end){
                this.searchData(condition);
            } else {
                this.findAllSales(condition);
            }
        }
    };

    nextPage = () => {
        if (
            this.state.currentPage <
            Math.ceil(this.state.totalElements / this.state.salesPerPage)
        ) {
            if (this.state.search) {
                this.searchData(this.state.currentPage + 1);
            } else if(this.state.search_magazine){
                this.searchData(this.state.currentPage + 1);
            }else if(this.state.search_date_start){
                this.searchData(this.state.currentPage + 1);
            }else if(this.state.search_date_end){
                this.searchData(this.state.currentPage + 1);
            } else {
                this.findAllSales(this.state.currentPage + 1);
            }
        }
    };

    searchChange = (event) => {
        this.setState({
            [event.target.name]: event.target.value,
        });
    };

    cancelSearch = () => {
        this.setState({ search: "" });
        this.findAllSales(this.state.currentPage);
    };
    cancelSearchMagazine = () => {
        this.setState({ search_magazine: "" });
        this.findAllSales(this.state.currentPage);
    };
    cancelSearchDateStart = () => {
        this.setState({ search_date_start: "" });
        this.findAllSales(this.state.currentPage);
    };
    cancelSearchDateEnd = () => {
        this.setState({ search_date_end: "" });
        this.findAllSales(this.state.currentPage);
    };

    searchData = (currentPage) => {
        currentPage -= 1;
        axios
            .get(
                "http://localhost:8080/rest/sales/search/" +
                this.state.search +
                "?page=" +
                currentPage +
                "&size=" +
                this.state.salesPerPage
            )
            .then((response) => response.data)
            .then((data) => {
                this.setState({
                    sales: data.content,
                    totalPages: data.totalPages,
                    totalElements: data.totalElements,
                    currentPage: data.number + 1,
                });
            });
    };

    searchDataMagazine = (currentPage) => {
        currentPage -= 1;
        axios
            .get(
                "http://localhost:8080/rest/sales/search/" +
                this.state.search_magazine +
                "?page=" +
                currentPage +
                "&size=" +
                this.state.salesPerPage
            )
            .then((response) => response.data)
            .then((data) => {
                this.setState({
                    sales: data.content,
                    totalPages: data.totalPages,
                    totalElements: data.totalElements,
                    currentPage: data.number + 1,
                });
            });
    };

    searchDataDateStart = (currentPage) => {
        currentPage -= 1;
        axios
            .get(
                "http://localhost:8080/rest/sales/search/" +
                this.state.search_date_start +
                "?page=" +
                currentPage +
                "&size=" +
                this.state.salesPerPage
            )
            .then((response) => response.data)
            .then((data) => {
                this.setState({
                    sales: data.content,
                    totalPages: data.totalPages,
                    totalElements: data.totalElements,
                    currentPage: data.number + 1,
                });
            });
    };

    searchDataDateEnd = (currentPage) => {
        currentPage -= 1;
        axios
            .get(
                "http://localhost:8080/rest/sales/search/" +
                this.state.search_date_end +
                "?page=" +
                currentPage +
                "&size=" +
                this.state.salesPerPage
            )
            .then((response) => response.data)
            .then((data) => {
                this.setState({
                    sales: data.content,
                    totalPages: data.totalPages,
                    totalElements: data.totalElements,
                    currentPage: data.number + 1,
                });
            });
    };

    render() {
        const { sales, currentPage, totalPages, search, search_magazine, search_date_start, search_date_end } = this.state;
        return (
            <div>
                <div style={{ display: this.state.show ? "block" : "none" }}>
                    <MyToast
                        show={this.state.show}
                        message={"Sale Deleted Successfully."}
                        type={"danger"}
                    />
                </div>
                <Card className={"border border-dark bg-dark text-white"}>
                    <Card.Header>
                        <div style={{ float: "left" }}>
                            <FontAwesomeIcon icon={faList} /> Sale List
                        </div>
                        <div style={{ float: "right" }}>
                            <InputGroup size="sm">
                                <FormControl
                                    placeholder="Search name"
                                    name="search"
                                    value={search}
                                    className={"info-border bg-dark text-white"}
                                    onChange={this.searchChange}
                                />
                                <InputGroup.Append>
                                    <Button
                                        size="sm"
                                        variant="outline-info"
                                        type="button"
                                        onClick={this.searchData}
                                    >
                                        <FontAwesomeIcon icon={faSearch} />
                                    </Button>
                                    <Button
                                        size="sm"
                                        variant="outline-danger"
                                        type="button"
                                        onClick={this.cancelSearch}
                                    >
                                        <FontAwesomeIcon icon={faTimes} />
                                    </Button>
                                </InputGroup.Append>
                            </InputGroup>
                            <InputGroup size="sm">
                                <FormControl
                                    placeholder="Search magazine"
                                    name="search_magazine"
                                    value={search_magazine}
                                    className={"info-border bg-dark text-white"}
                                    onChange={this.searchChange}
                                />
                                <InputGroup.Append>
                                    <Button
                                        size="sm"
                                        variant="outline-info"
                                        type="button"
                                        onClick={this.searchDataMagazine}
                                    >
                                        <FontAwesomeIcon icon={faSearch} />
                                    </Button>
                                    <Button
                                        size="sm"
                                        variant="outline-danger"
                                        type="button"
                                        onClick={this.cancelSearchMagazine}
                                    >
                                        <FontAwesomeIcon icon={faTimes} />
                                    </Button>
                                </InputGroup.Append>
                            </InputGroup>
                            <InputGroup size="sm">
                                <FormControl
                                    placeholder="Search date start"
                                    name="search_date_start"
                                    value={search_date_start}
                                    className={"info-border bg-dark text-white"}
                                    onChange={this.searchChange}
                                />
                                <InputGroup.Append>
                                    <Button
                                        size="sm"
                                        variant="outline-info"
                                        type="button"
                                        onClick={this.searchDataDateStart}
                                    >
                                        <FontAwesomeIcon icon={faSearch} />
                                    </Button>
                                    <Button
                                        size="sm"
                                        variant="outline-danger"
                                        type="button"
                                        onClick={this.cancelSearchDateStart}
                                    >
                                        <FontAwesomeIcon icon={faTimes} />
                                    </Button>
                                </InputGroup.Append>
                            </InputGroup>
                            <InputGroup size="sm">
                                <FormControl
                                    placeholder="Search date end"
                                    name="search_date_end"
                                    value={search_date_end}
                                    className={"info-border bg-dark text-white"}
                                    onChange={this.searchChange}
                                />
                                <InputGroup.Append>
                                    <Button
                                        size="sm"
                                        variant="outline-info"
                                        type="button"
                                        onClick={this.searchDataDateEnd}
                                    >
                                        <FontAwesomeIcon icon={faSearch} />
                                    </Button>
                                    <Button
                                        size="sm"
                                        variant="outline-danger"
                                        type="button"
                                        onClick={this.cancelSearchDateEnd}
                                    >
                                        <FontAwesomeIcon icon={faTimes} />
                                    </Button>
                                </InputGroup.Append>
                            </InputGroup>
                        </div>
                    </Card.Header>
                    <Card.Body>
                        <Table bordered hover striped variant="dark">
                            <thead>
                            <tr>
                                <th>Title</th>
                                <th>Magazine</th>
                                <th>OLD_PRICE</th>
                                <th onClick={this.sortData}>
                                    NEW_PRICE{" "}
                                    <div
                                        className={
                                            this.state.sortDir === "asc"
                                                ? "arrow arrow-up"
                                                : "arrow arrow-down"
                                        }
                                    >
                                        {" "}
                                    </div>
                                </th>
                                <th>date_start</th>
                                <th>date_end</th>
                            </tr>
                            </thead>
                            <tbody>
                            {sales.length === 0 ? (
                                <tr align="center">
                                    <td colSpan="7">No Sales Available.</td>
                                </tr>
                            ) : (
                                sales.map((sale) => (
                                    <tr key={sale.id}>
                                        <td>
                                            <Image
                                                src={sale.coverPhotoURL}
                                                roundedCircle
                                                width="25"
                                                height="25"
                                            />{" "}
                                            {sale.title}
                                        </td>
                                        <td>{sale.author}</td>
                                        <td>{sale.isbnNumber}</td>
                                        <td>{sale.price}</td>
                                        <td>{sale.language}</td>
                                        <td>{sale.genre}</td>
                                    </tr>
                                ))
                            )}
                            </tbody>
                        </Table>
                    </Card.Body>
                    {sales.length > 0 ? (
                        <Card.Footer>
                            <div style={{ float: "left" }}>
                                Showing Page {currentPage} of {totalPages}
                            </div>
                            <div style={{ float: "right" }}>
                                <InputGroup size="sm">
                                    <InputGroup.Prepend>
                                        <Button
                                            type="button"
                                            variant="outline-info"
                                            disabled={currentPage === 1 ? true : false}
                                            onClick={this.firstPage}
                                        >
                                            <FontAwesomeIcon icon={faFastBackward} /> First
                                        </Button>
                                        <Button
                                            type="button"
                                            variant="outline-info"
                                            disabled={currentPage === 1 ? true : false}
                                            onClick={this.prevPage}
                                        >
                                            <FontAwesomeIcon icon={faStepBackward} /> Prev
                                        </Button>
                                    </InputGroup.Prepend>
                                    <FormControl
                                        className={"page-num bg-dark"}
                                        name="currentPage"
                                        value={currentPage}
                                        onChange={this.changePage}
                                    />
                                    <InputGroup.Append>
                                        <Button
                                            type="button"
                                            variant="outline-info"
                                            disabled={currentPage === totalPages ? true : false}
                                            onClick={this.nextPage}
                                        >
                                            <FontAwesomeIcon icon={faStepForward} /> Next
                                        </Button>
                                        <Button
                                            type="button"
                                            variant="outline-info"
                                            disabled={currentPage === totalPages ? true : false}
                                            onClick={this.lastPage}
                                        >
                                            <FontAwesomeIcon icon={faFastForward} /> Last
                                        </Button>
                                    </InputGroup.Append>
                                </InputGroup>
                            </div>
                        </Card.Footer>
                    ) : null}
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
        deleteSale: (saleId) => dispatch(deleteSale(saleId)),
    };
};

export default connect(mapStateToProps, mapDispatchToProps)(SaleList);
