const express = require('express');

// Creating the express app
const app = express()

// Chosing a port to run on
const port = 3000


// Store the product list in memory:
const productList = [
	{
		id: "product_1",
		name: "Milk",
		price: 2
	}
]

// Adding a simple endpoint
app.get('/', (request, response) => {
  response.send('Bye World!')
})



app.get("/products/:productId", (request, response) => {
    // get the product Id from the request object
    const productId = request.params.productId;
  
    // filter the right product from the product list
    const product = productList.find((prod) => prod.id == productId);
  
    // return a 404 status if no product is found
    if (!product) {
      response.status(404).end();
    }
  
    // Send the product object as a JSON response to the client
    response.json(product);
  });




app.listen(port, () => {
  console.log(`Example app listening at http://localhost:${port}`)
})