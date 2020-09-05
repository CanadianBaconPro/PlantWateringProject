const express = require('express')
const { timeout } = require('async')
const app = express()

function watertimeout(req)
{
    return true
}

async function asyncCall() 
{
  console.log('calling');
  const result = await resolveAfter2Seconds();
  console.log(result);
  // expected output: "resolved"
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
    if(watertimeout() == true)
    {
        res.render('success')
    }
    else
    {
        res.redirect('index')
    }
})

// Set view engine to ejs with a static webpage
app.use(express.static(__dirname + '/views/'))
app.set('view engine', 'ejs')