import { Layout, Typography, Button} from "antd";
import { useState } from "react";
import LoginForm from "./components/LoginForm";
import FoodList from "./components/FoodList" 
import MyCart from "./components/MyCart"
import RegistrationForm from "./components/RegistrationForm";
import BusinessLogin from "./components/BusinessLogin"
import BusinessRegistration from "./components/BusinessRegistration"


const { Header, Content } = Layout;
const { Title } = Typography;

 
function App() { 
  const [authed, setAuthed] = useState(false);
  const [formType, setFormType] = useState('Login')
  const [userType, setUserType] = useState('Customer')
 
  return (
    <Layout style={{ height: "100vh" }}>
      <Header>
        <div className="header" style = 
        {{display: "flex", 
        justifyContent: "space-between"}}>
          <Title
            level={2}
            style={{ color: "white", lineHeight: "inherit", marginBottom: 0 }}
          >
            Lai Food
          </Title>
          {authed && (
            <div>
              <MyCart />
            </div>
          )}
        </div>
      </Header>
      <Content
        style={{
          padding: "50px",
          maxHeight: "calc(100% - 64px)",
          overflowY: "auto",
        }}
      >
        <div >
        {authed ? (
          <FoodList />) : (
          formType === 'Login' ? ( userType ==='Customer' ? 
            (<LoginForm onSuccess={() => setAuthed(true)} registerForm={()=>setFormType('Register')} />) :
            (<BusinessLogin onSuccess={() => setAuthed(true)} registerForm={()=>setFormType('Register')} />)
          ) : (userType ==='Customer' ?
            (<RegistrationForm onSuccess={()=>setFormType('Login')} toLoginForm={()=>setFormType('Login')}/>) :
            (<BusinessRegistration onSuccess={()=>setFormType('Login')} toLoginForm={()=>setFormType('Login')}/>)
          )          
        )} 
        { authed ? ("") : (      
            userType ==='Customer' ? (
              <Button type="primary" htmlType="submit" onClick={()=>setUserType('Business')}>
                Business User ?
              </Button>
            ) : (
              <Button type="primary" htmlType="submit" onClick={()=>setUserType('Customer')}>
                Customer User ?
              </Button>
            )
        )}
        
      </div>
         
         
      </Content>
    </Layout>
  );

}
 
export default App;
