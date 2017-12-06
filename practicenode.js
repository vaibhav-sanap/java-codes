var mysql = require('mysql');

var con = mysql.createConnection({
    host:"localhost",
    username:"username",
    password:"password"

});

con.connect(function(err){
    if(err) throw err;
    console.log("connected");

    con.query(sql,function(err,data){});
});