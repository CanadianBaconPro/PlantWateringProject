const express = require('express')
const app = express()


// Port for Node.js server to listen on
port = 8080

app.listen(port, function()
{
    console.log('Node listening on Port %s', port)
})

// Root url request page
app.get('/', function(req, res)
{
    res.render('index')
})

// Set view engine to ejs with a static webpage
app.use(express.static(__dirname + '/views/'))
app.set('view engine', 'ejs')