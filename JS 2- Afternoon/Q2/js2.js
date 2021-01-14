var Students=[];
function validate() 
    {
    var regex = /[a-zA-Z]$/;
    if( document.getElementsByName("firstname")[0].value == "" ) {
        alert( "Please provide your first name!" );
        return false;
    }
    console.log(document.getElementsByName("firstname")[0].value);
    if(regex.test(document.getElementsByName("firstname")[0].value) == false){
        alert("First Name must be in alphabets only");
        return false;
    }


    if( document.getElementsByName("lastname")[0].value == "" ) {
        alert( "Please provide your last name!" );
        return false;
    }
    if(regex.test(document.getElementsByName("lastname")[0].value) == false){
        alert("Last Name must be in alphabets only");
        return false;
    }

    var regexx= /[0-9]$/;
    if( document.getElementsByName("roll")[0].value == "" ) {
        alert( "Please provide your Roll Number!" );
        return false;
    }
    if(regexx.test(document.getElementsByName("roll")[0].value) == false){
        alert("Roll Number must be in Numbers only");
        return false;
    }


    var rege= /[0-9]$/;
    if( document.getElementsByName("age")[0].value == "" ) {
        alert( "Please provide your Age!" );
        return false;
    }
    if(rege.test(document.getElementsByName("age")[0].value) == false){
        alert("Age must be in Numbers only");
        return false;
    }

    var regdob= /[0[1-9]|[12][0-9]|3[01]][-/.][0[1-9]|1[012]][-/.][19|20][0-9][0-9]$/;
    if( document.getElementsByName("dob")[0].value == "" ) {
        alert( "Please provide your DOB!" );
        return false;
    }
    if(regdob.test(document.getElementsByName("dob")[0].value) == false){
        alert("Incorrect DOB");
        return false;
    }

    var gen;
    if(document.getElementById('male').checked) {
    gen= "Male";
    }else if(document.getElementById('female').checked) {
    gen= "Female";
    }
    else if(document.getElementById('other').checked) {
    gen= "Other";
    }
    else{
        alert( "Please provide your Gender!" );
        return false;
    }

    

    console.log("First Name : "+ document.getElementsByName("firstname")[0].value);
    console.log("Last Name : "+ document.getElementsByName("lastname")[0].value);
    console.log("Age : "+ document.getElementsByName("age")[0].value);
    console.log("DOB : "+ document.getElementsByName("dob")[0].value);
    console.log("Roll Number : "+ document.getElementsByName("roll")[0].value);
    console.log("Gender : "+ gen);
    return( true );
}


var Student = {Firstname: "", Lastname: "", Age:0, RollNo:0, Gender:"", DOB:""};

function addfields(first,last,age,roll,gen,dob)
{
    Student.Firstname=first;
    Student.Lastname=last;
    Student.Age=age;
    Student.RollNo=roll;
    Student.Gender=gen;
    Student.DOB=dob;
}
function addOccupation()
{
    var occ= document.getElementsByName("occ")[0].value;
    Student.Occupation=occ;
    alert("Occupation added");
}

function main()
{
    if (validate())
    {
        var first=document.getElementsByName("firstname")[0].value;
        var last=document.getElementsByName("lastname")[0].value;
        var age=document.getElementsByName("age")[0].value;
        var dob=document.getElementsByName("dob")[0].value;
        var roll=document.getElementsByName("roll")[0].value;
        var gen="";
        if(document.getElementById('male').checked) {
        gen= "Male";
        }else if(document.getElementById('female').checked) {
        gen= "Female";
        }
        else if(document.getElementById('other').checked) {
        gen= "Other";
        }
        addfields(first, last,age,roll,gen,dob);
        Students.push(Student);
    }
}
function searchroll()
{
    var roll= parseInt(document.getElementsByName("roll")[0].value);
    let obj = Students.find(Student => Student.RollNo == roll);
    console.log(obj.Firstname);
    alert(    obj.Firstname+"\n"+
        obj.Lastname+"\n"+
        obj.Age+"\n"+
        obj.RollNo+"\n"+
        obj.Gender+"\n"+
        obj.DOB+"\n"+
        obj.Occupation
        );

}