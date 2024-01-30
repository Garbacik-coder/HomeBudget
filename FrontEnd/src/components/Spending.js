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

export default function Spending() {
    const paperStyle={padding:'50px 20px', width:600,margin:"20px auto"}
    const[name,setName]=useState('')
    const[address,setAddress]=useState('')
    const[spendings,setSpendings]=useState([])
     const classes = useStyles();

  const handleClick=(e)=>{
    e.preventDefault()
    const spending={name,address}
    console.log(spending)
    fetch("http://localhost:8080/spending/add",{
      method:"POST",
      headers:{"Content-Type":"application/json"},
      body:JSON.stringify(spending)

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
      value={address}
      onChange={(e)=>setAddress(e.target.value)}
      />
      <Button variant="contained" color="secondary" onClick={handleClick}>
  Dodaj
</Button>
    </form>
   
    </Paper>
    <h1>Lista Wydatków</h1>

    <Paper elevation={3} style={paperStyle}>

      {Spendings.map(spending=>(
        <Paper elevation={6} style={{margin:"10px",padding:"15px", textAlign:"left"}} key={spending.id}>
         Id:{spending.id}<br/>
         Nazwa: {spending.name}<br/>
         Kwota: {spending.kwota}

        </Paper>
      ))
}


    </Paper>



    </Container>
  );
}
