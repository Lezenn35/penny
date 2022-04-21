import './style.css'
import Character from "./character/Character";
import RenderTree from "./core/RenderTree";
import WorldMap from "./core/WorldMap";

const player = new Character(15, 15, 'red');
const world = new WorldMap(150);
const world2 = new WorldMap(125);
const world3 = new WorldMap(100);
const world4 = new WorldMap(75);
const world5 = new WorldMap(50);
const world6 = new WorldMap(25);
const renderTree = new RenderTree(world);
renderTree.addChild(world2);
renderTree.addChild(world3);
renderTree.addChild(world4);
renderTree.addChild(world5);
renderTree.addChild(world6);


const gameWindow = document.querySelector("#gameWindow") as HTMLCanvasElement;
gameWindow.setAttribute('width', '' + window.innerWidth);
gameWindow.setAttribute('height', '' + window.innerHeight);

let ctx = gameWindow.getContext('2d');
if (ctx) {
    renderTree.render(ctx);
}

// setInterval(() => {
//
// }, (1000 / 60))