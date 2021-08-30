import { Button, Table } from 'reactstrap';
import React, { useState, useEffect } from 'react'
import service from './service'
import alertify from "alertifyjs"
import { useHistory } from 'react-router-dom';

function NoteList() {
  const [note, setNote] = useState([])
  let history = useHistory();
  useEffect(() => {
    service.liste().then(result => {
      setNote(result.data)
    })
  })

  const deleteNote = (id) => {
    let del = { id }
    service.delete(del).then(() => alertify.success("Not Silindi", 1.5)).catch(() => alertify.danger("Note Silinemedi", 1.5));
  }

  const addNote = () => {
    history.push('/add')
  }

  const updateNote = (id) => {
    history.push(`/update/${id}`)
  }

  return (
    <div >
      <Button onClick={() => addNote()} className="btn btn-success">Yeni Not Ekle</Button>
      <Table>
        <thead>
          <tr>
            <th>#</th>
            <th>Not Başlığı</th>
            <th>Not İçeriği</th>
            <th>Oluşturulma Tarihi</th>
            <th></th>
          </tr>
        </thead>
        <tbody>
          {
            note.map((not, index) => (
              <tr key={index}>
                <th>{index}</th>
                <td>{not.title}</td>
                <td>{not.contents}</td>
                <td>{not.date}</td>
                <td><button onClick={() => updateNote(not.id)} className="btn btn-success">Notu Düzenle</button></td>
                <td><button onClick={() => deleteNote(not.id)} className="btn btn-danger">Sil</button></td>
              </tr>
            ))
          }
        </tbody>
      </Table>
    </div>
  );
}

export default NoteList;
