import fastify from "fastify";
import fastify_websocket from "fastify-websocket";

const server = fastify();
server.register(fastify_websocket);

server.get('/', { websocket: true }, (connection, request) => {
    connection.socket.on('message', (message) => {
        console.log(message);
        connection.socket.send('Received: ' + message);
    })
});

server.listen(3001, err => {
    if (err) {
        server.log.error(err);
        process.exit(1);
    }
})