//import Styles from '!style-loader!css-loader?modules!./styles.css'
const express = require('express')
const app = express()


//async function reload()
//{
//    await new Promise(r => setTimeout(r, 2000));
//}

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
    //while(true)
    //{
    //    reload()
    //    
    //    console.log("reloaded")
    //}
})

// Set view engine to ejs with a static webpage
app.use(express.static(__dirname + '/views/'))
app.set('view engine', 'ejs')