const express = require('express')
const app = express()

// This should take the server time so clients should not be able to change their local time to get around the cool down???
// not yet tested 
var time = -1
function watertimeout(req)
{
    var mins = new Date()
    var currentTime = mins.getMinutes()
    
    // this is just a temporary way to avoid spamming of the water function
    if ((currentTime - time) > 2 || time == -1)
    {
        time = currentTime
        return true
    }
    else 
    {
        return false
    }
    // This is where we will send the request to the java program to start the plant watering 
}

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

app.post('/waternow', function(req, res)
{
    if (watertimeout() == true)
    {
        res.render('success')
    }
    else
    {
        res.render('failure')
    }
})

// Set view engine to ejs with a static webpage
app.use(express.static(__dirname + '/views/'))
app.set('view engine', 'ejs')