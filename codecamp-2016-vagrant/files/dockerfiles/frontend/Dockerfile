FROM node

MAINTAINER sklose@next-level-intgegration.com

ENV HOME=/usr/src/app
#ENV PROJECTROOT=codecamp-2016-frontend-webapp
RUN mkdir $HOME
#ADD $PROJECTROOT/src $HOME/src
#ADD $PROJECTROOT/angular-cli.json $HOME/angular-cli.json
#ADD $PROJECTROOT/package.json $HOME/package.json
#ADD $PROJECTROOT/tslint.json $HOME/tslint.json
WORKDIR $HOME

RUN npm install

RUN npm install -g angular-cli

EXPOSE 4200
#EXPOSE 49153

#ENTRYPOINT ["/bin/bash"]
#CMD [ "npm", "start" ]

CMD ["ng", "serve", "--host", "0.0.0.0"]
