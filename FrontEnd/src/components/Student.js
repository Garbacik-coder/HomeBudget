import React, { useEffect, useState } from 'react';
import { makeStyles } from '@material-ui/core/styles';
import TextField from '@material-ui/core/TextField';
import { Container ,Paper,Button} from '@material-ui/core';

const useStyles = makeStyles((theme) => ({
  root: {
    '& > *': {
      margin: theme.spacing(1),
     
    },
  },
}));

export default function Student() {
    const paperStyle={padding:'50px 20px', width:600,margin:"20px auto"}
    const[name,setName]=useState('')
    const[value,setValue]=useState('')
    const[category,setCategory]=useState('')
    const[spendings,setSpendings]=useState([])
     const classes = useStyles();

  const handleClick=(e)=>{
    e.preventDefault()
    const student={name,value, category}
    console.log(student)
    fetch("http://localhost:8080/spending/add",{
      method:"POST",
      headers:{"Content-Type":"application/json"},
      body:JSON.stringify(student)

  }).then(()=>{
    console.log("New cost added")
  })
}

useEffect(()=>{
  fetch("http://localhost:8080/spending/getAll")
  .then(res=>res.json())
  .then((result)=>{
    setSpendings(result);
  }
)
},[])
  return (

    <Container>
        <Paper elevation={3} style={paperStyle}>
            <h1 style={{color:"blue"}}><u>Dodaj wydatek</u></h1>

    <form className={classes.root} noValidate autoComplete="off">
    
    <TextField id="outlined-basic" label="Nazwa wydatku" variant="outlined" fullWidth
    value={name}
    onChange={(e)=>setName(e.target.value)}
    />
    <TextField id="outlined-basic" label="Kwota" variant="outlined" fullWidth
    value={value}
    onChange={(e)=>setValue(e.target.value)}
    />
    <TextField id="outlined-basic" label="Kategoria" variant="outlined" fullWidth
    value={category}
    onChange={(e)=>setCategory(e.target.value)}
    />
    <Button variant="contained" color="secondary" onClick={handleClick}>
  Dodaj
</Button>
    </form>
   
    </Paper>
    <h1>Lista Wydatków</h1>

    <Paper elevation={3} style={paperStyle}>

      {spendings.map(wydatek=>(
        <Paper elevation={6} style={{margin:"10px",padding:"15px", textAlign:"left"}} key={wydatek.id}>
         Id:{wydatek.id}<br/>
         Nazwa: {wydatek.name}<br/>
         Kwota: {wydatek.kwota}

        </Paper>
      ))
}


    </Paper>



    </Container>
  );
}
