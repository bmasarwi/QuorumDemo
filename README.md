# QuorumDemo

Using this demo you'll be able to setup a blockchain network (using Quorum Maker), deploy a smart contract and interact with it.

Step by setp guide: 

First we need to setup a test/development Quorum network with two nodes through [Quorum Maker](https://github.com/synechron-finlabs/quorum-maker/wiki#setting-up-quorum-testdevelopment-network):

1. Clone quorum maker from [Quorum Maker github repository](https://github.com/synechron-finlabs/quorum-maker.git)

2. Run the following command to create a Quorum development network with two nodes and tessera as privacy layer:
    * `./setup.sh dev -p <projectName> -n 2`
    * Make sure to replace <projectName> with your project name

3. Quorum maker will print to the cmd the following, we will need them later:
    * Node public keys
    * RPC/Node manager ports

4. Navigate to the directory created and run the network in docker (you'll need to install `docker-compose` if you haven't already done it):
    * `cd <projectName>`
    * `docker-compose up`

Now you can access NodeManager UI through:
  - node1: http://localhost:20104 
  - node1: http://localhost:20204

** Note: the above URLs have been produced on a MacOS X system and you might need to change them according to the NodeManager information printed by QuorumMaker when starting.

Through NodeManager UI, compile and deploy your contract:
  - Click on “Compile & Deploy Contract”
  - Choose your solidity file
  - Choose the other node to be “privateFor” 

After the contract has been deployed, you'll be able to start interacting with it (see the code in this repo).
