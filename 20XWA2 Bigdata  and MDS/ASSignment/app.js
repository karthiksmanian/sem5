const mongoose = require('mongoose');
mongoose.connect('mongodb://localhost:27017/TitanicDisasterDB', {useNewUrlParser: true});

const victimSchema = new mongoose.Schema ({
    survived:{
        type: Boolean
    },
    name:{
        type:String
    },
    sex:{
        type:String
    },
    age:{
        type:Number
    },
    ticket:{
        type:String
    },
    fare:{
        type:Number
    },
    cabin:{
        type:String
    }
});

const Victim = mongoose.model("Victim",victimSchema);

const victim = new Victim({
        survived: 0,
        name: "Braund",
        sex: "male",
        age: 22,
        ticket: "A/5 21171",
        fare: 7.25,
        cabin: "C85"
});

// victim.save();
const victim2 = new Victim({
    survived: 1,
    name: "Heikkinen",
    sex: "female",
    age: 26,
    ticket: "STON/O2. 3101282",
    fare: 7.925,
    cabin: "C123"
});
const victim3 = new Victim({
    survived: 1,
    name: "Futrelle",
    sex: "female",
    age: 35,
    ticket: "113803",
    fare: 53.1,
    cabin: "C123"
});
const victim4 = new Victim({
    survived: 0,
    name: "Allen",
    sex: "male",
    age: 35,
    ticket: "373450",
    fare: 8.05,
    cabin: "C103"
});


Victim.insertMany([victim2,victim3,victim4],function(err){
    if(err){
        console.log(err);
    }else{
        console.log("Insertion sucessful.");
    }
});

// // Victim.find(function(err, victims){
// //     if(err){
// //         console.log(err);
// //     }
// //     else{
// //         mongoose.connection.close();

// //         victims.forEach(function(victim){
// //             console.log(victim.name);
// //         })  
// //     }
// // })

// // populate();
// // find();
// records  = Victim.find();
// console.log(records);