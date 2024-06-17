const animalsEndpoint = 'http://localhost:3000/api/animals';
const options = {
    method: 'GET',
    headers: {
        'Accept' : 'application/json'
    }
}

/* GET travel view */
const animals = async function(req, res, next) {
    await fetch(animalsEndpoint, options)
        .then(res => res.json())
        .then(json => {
            let message = null;
            if(!(json instanceof Array)) {
                message = 'API lookup error';
                json = [];
            } else {
                if(!json.length) {
                    message = 'No animals exist in our database!';
                }
            }
            res.render('animals', {title: 'Grazioso Salvare', trips: json, message});
        })
        .catch(err => res.status(500).send(e.message));
};

module.exports = {
    animals
}