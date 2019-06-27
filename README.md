# QuorumDemo
Using Quorum Maker to setup a blockchain network, deploying a contract and interacting with it

Setup a test/development Quorum network with two nodes (https://github.com/synechron-finlabs/quorum-maker/wiki#setting-up-quorum-testdevelopment-network) through quorum maker

1- Clone quorum maker from https://github.com/synechron-finlabs/quorum-maker.git 

2- Run the following command to create the network:
 ./setup.sh dev --tessera --project <projectName> --nodecount 2


3- Quorum maker will print to the cmd the following, we will need them later:
  Node public keys
  RPC/Node manager ports 

4- Navigate to the directory created and run docker-compose up

Now you can access NodeManager UI through:
  node1: http://localhost:20104 
  node1: http://localhost:20204

Above URLs are valid if you’re using OSX, otherwise change the port according to the NodeManager ports printed by QuorumMaker to the cmd 

Through NodeManager UI, compile and deploy your contract.
  Click on “Compile & Deploy Contract”
  Choose your solidity file
  Choose the other node to be “privateFor” 

After the contract has been deployed, you’re able to start interacting with it. 


