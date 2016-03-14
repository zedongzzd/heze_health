import React from 'react';
import { Route ,Redirect ,IndexRoute ,DefaultRoute} from 'react-router';
import App   from  './containers/App';

export default function createRoutes() {
  return (
    <Route path="/" component={App}>
      
    </Route>
  )
}
