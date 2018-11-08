var layout = document.createElement("canvas");
var layoutStyle = layout.getContext("2d");
layout.width = 900;
layout.height = 506;
document.body.appendChild(layout);


var backgroundSet = false;
var zombieSet = false;
var brainsSet = false;


var backgroundImg = new Image();
var zombieImg = new Image();
var brainsImg = new Image();


backgroundImg.onload = function () {
    backgroundSet = true;
};

zombieImg.onload = function () {
    zombieSet = true;
};

brainsImg.onload = function () {
    brainsSet = true;
};


backgroundImg.src = "img/background.png";
zombieImg.src = "img/zombie2.png";
brainsImg.src = "img/brains.png";


var brainsCaught = 0;

var zombie = {
    speed: 500 
};
var brains = {

};
var keyDown = {

};


addEventListener("keydown", function (e) {
    keyDown[e.keyCode] = true;
}
, false);

addEventListener("keyup", function (e) {
    delete keyDown[e.keyCode];
}
, false);



function newGame() {
    zombie.x = layout.width / 2;
    zombie.y = layout.height / 2;
   
    brains.x = (Math.random() * (layout.width - 100));
    brains.y = (Math.random() * (layout.height - 100));
};



function moveZombie(condition) {
    if (37 in keyDown) { //left
       zombie.x -= zombie.speed * condition;
    }

    if (38 in keyDown) { //up
      zombie.y -= zombie.speed * condition;
    }
    if (40 in keyDown) { //down
       zombie.y += zombie.speed * condition;
    }
  
    if (39 in keyDown) { //right
       zombie.x += zombie.speed * condition;
    }

   
    if (
        zombie.x <= (brains.x + 40)
        && brains.x <= (zombie.x + 40)
        && zombie.y <= (brains.y + 40)
        && brains.y <= (zombie.y + 40)
    ) 
    {
        ++brainsCaught;
        newGame();
    }
};




function setUp() {
    if (backgroundSet) 
    {
        layoutStyle.drawImage(backgroundImg, 0, 0);
    }

    if (zombieSet)
    {
        layoutStyle.drawImage(zombieImg, zombie.x, zombie.y);
    }

    if (brainsSet)
    {
        layoutStyle.drawImage(brainsImg, brains.x, brains.y);
    }

    layoutStyle.fillStyle = "rgb(124, 252, 0)";

    layoutStyle.font = "36px Times New Roman";

    layoutStyle.textAlign = "left";

    layoutStyle.textBaseline = "top";

    layoutStyle.fillText("Brains Ate: " + brainsCaught, 40, 40);
};


function docReady() {
    moveZombie((Date.now() - then) / 1000);
    setUp();

    then = Date.now();
    requestAnimationFrame(docReady);
};


var then = Date.now();
newGame();
docReady();