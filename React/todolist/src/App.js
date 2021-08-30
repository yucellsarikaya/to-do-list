import { Route, Switch } from "react-router-dom";
import NoteList from "./NoteList";
import NoteAdd from "./NoteAdd";
import NoteUpdate from "./NoteUpdate";

function App() {
  return (
    <div >
      <Switch>
        <Route exact path="/" render={props => (<NoteList />)} />
        <Route exact path="/add" render={props => (<NoteAdd />)} />
        <Route exact path="/update/:id" render={props => (<NoteUpdate {...props} />)} />
      </Switch>
    </div>
  );
}

export default App;
