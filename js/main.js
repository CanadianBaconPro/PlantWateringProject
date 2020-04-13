const express = require("express")
const app = express()

app.listen(8080, function()
{
    console.log('Node listening on Port 8080')
})

app.get('/', function(req, res)
{
    res.render('index', {name: 'Hello'}) // Render index if accessing main page
})

app.use(express.static(__dirname + '/views/'))
app.set('view engine', 'ejs')