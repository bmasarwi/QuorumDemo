pragma solidity ^0.5.2;

contract HelloWorld {
    string data;

    function set(string memory x) public {
        data = x;
    }

    function get() public view returns (string memory) {
        return data;
    }
}