import './style.css'
import RenderTree from "./core/RenderTree";
import WorldMap from "./core/WorldMap";
import Player from "./core/Player";

const world = new WorldMap(150);
const renderTree = new RenderTree(world);
renderTree.addChild(new RenderTree(new Player('red', 'darkred')))

const gameWindow = document.querySelector("#gameWindow") as HTMLCanvasElement;
gameWindow.setAttribute('width', '' + window.innerWidth);
gameWindow.setAttribute('height', '' + window.innerHeight);

let ctx = gameWindow.getContext('2d');
if (ctx) {
    renderTree.render(ctx);
}

// Server link

const serverConnection = new WebSocket('localhost:3001');
serverConnection.send("Hello World !");
serverConnection.close();

// setInterval(() => {
//
// }, (1000 / 60))