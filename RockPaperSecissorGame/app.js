
let user=document.querySelector("#user-score");
let comp=document.querySelector("#comp-score");


const choices = document.querySelectorAll(".choice");

const getCompChoice = () =>{
    const opt =["rock", "paper", "scissors"];
    //Comp Choice
    return opt[Math.floor(3*Math.random())];
}

const drawGame = () =>{
    console.log("Game is Draw");
    let msg = document.querySelector("#msg");
    msg.innerText="Game is Draw. Play Again";
    msg.style.backgroundColor="navy";
}
const playGame=(userChoice)=>{
const compChoice = getCompChoice();
console.log(`user Choice is ${userChoice} & Computer Choice is ${compChoice}`);
if(userChoice===compChoice){
    drawGame();
}
else{
    let userWin=true;
    if(userChoice==="rock"){
        userWin=(compChoice==="paper")?false:true;
    }
    else if(userChoice==="paper"){
        userWin=(compChoice==="scissors")?false:true;
    }
    else {
        userWin=(compChoice==="rock")?false:true;

    }
    displayWinner(userWin);
    }
}
let displayWinner =(userWin)=>{
    let msg = document.querySelector("#msg");

    if(userWin){
        console.log("User Wins");
        msg.innerText="User Wins";
        msg.style.backgroundColor="green";
        user.innerText++;
    }
    else
    {
        console.log("Computer Wins");
        msg.innerText="Computer Wins";
        msg.style.backgroundColor="red";
        comp.innerText++;
    }
}
choices.forEach((choice=>{
    choice.addEventListener("click",()=>{
        let userChoice=choice.getAttribute("id");
        playGame(userChoice);
    })
}))