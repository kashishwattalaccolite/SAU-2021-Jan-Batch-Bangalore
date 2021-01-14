class input {
    constructor(param) {
        this.input = param;
    }
    calculateLength() {
        console.log("Length: "+ this.input.length);
        return this.input.length;
    };
    getUpperCase() {
        console.log("UpperCase: "+ this.input.toUpperCase());
        return this.input.toUpperCase();
    };
    getLowerCase() {
        console.log("LowerCase: "+ this.input.toLowerCase());
        return this.input.toLowerCase();
    };
    getvow() {
        var str = this.input; 
        var vowels = str.match(/[aeiouAEIOU]/gi); 
        console.log("Vowels: "+ vowels);
        return vowels
    };
    getcon() {
    var str = this.input; 
    var consonants = str.match(/[^aeiouAEIOU]/gi);  
    console.log("Consonants: "+ consonants);
    return consonants;
    };
    validate()
    {
        var regex = /[^0-9]$/;
        if(regex.test(this.input) == false){
            alert("Input should not have number!");
            console.log("Input should not have number");
            return false;
         }
         return true;
    }

}

function callFunction() {
    var inputValue = document.getElementById("inputTxt").value;
    let inputObject = new input(inputValue);
    if (inputObject.validate())
    {   
        document.getElementById("lengthOp").innerHTML = inputObject.calculateLength();
        document.getElementById("ucOp").innerHTML = inputObject.getUpperCase();
        document.getElementById("lcOp").innerHTML = inputObject.getLowerCase();
        document.getElementById("vwOp").innerHTML = inputObject.getvow();
        document.getElementById("consOp").innerHTML = inputObject.getcon();
    }
}