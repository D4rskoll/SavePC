var canvas = document.querySelector('canvas');
var context = canvas.getContext('2d');
var rectangulo1 = {
    x: 20,
    y: 200
}
var ball = {
    x: 250,
    y: 250,
    velocidad: 5,
    angulo: 90,
    direction: 1,
    direccion: 1,
}
var rectangulo2 = {
    x: canvas.width -40,
    y: canvas.height -250   
}
var frame = 0;
function animation () {
    context.clearRect(0, 0, canvas.width, canvas.height);
    context.fillStyle = 'white';
    context.fillRect(rectangulo1.x, rectangulo1.y, 20, 120);
    context.fillRect(rectangulo2.x, rectangulo2.y, 20, 120);
    context.beginPath();
    context.arc(ball.x, ball.y, 10, 0, Math.PI*2);
    console.log(ball.x);
    context.fill();
    context.closePath();
    colision() ;
    ball.x -= 10 * ball.direccion;
    frame ++;
    
    setTimeout(()=>{
        requestAnimationFrame(animation)},
        1000/55
    );
    
    
}
document.addEventListener('keydown', (event)=>{
    keyCode = event.key;
    if (keyCode == "ArrowUp"){
        moveUp();
    }
    if (keyCode == "ArrowDown"){
        moveDown();
    }
});
function moveUp() {
    rectangulo1.y -= 10;
}
function moveDown() {
    rectangulo1.y += 10;
}
function colision() {
    if (ball.x - 10 <= rectangulo1.x + 20 && rectangulo1.y <= ball.y && ball.y <= rectangulo1.y +120) {
        ball.direccion = -1;
        
    }
    if (ball.x + 10 >= rectangulo2.x && rectangulo2.y <= ball.y && ball.y <= rectangulo2.y +120) {
        ball.direccion = 1;
    }
    
}
animation();