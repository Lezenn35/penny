import './style.css'
import Character from "./character/Character";
import RenderTree from "./core/RenderTree";
import WorldMap from "./core/WorldMap";

const player = new Character(15, 15, 'red');
const world = new WorldMap(50);
const renderTree = new RenderTree(world);


const gameWindow = document.querySelector("#gameWindow") as HTMLCanvasElement;

let ctx = gameWindow.getContext('2d');
if (ctx) {
    renderTree.render(ctx);
}

// setInterval(() => {
//
// }, (1000 / 60))